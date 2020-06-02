package com.ssm.chapter.pojo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

public class SshService {
	private Connection conn;
	private String ipAddr;
	private Charset charset = StandardCharsets.UTF_8;
	private String userName;
	private String password;

	public SshService(String ipAddr, String userName, String password, Charset charset) {
		this.ipAddr = ipAddr;
		this.userName = userName;
		this.password = password;
		if (charset != null) {
			this.charset = charset;
		}
	}

	/**
	 * 登录远程Linux主机
	 *
	 * @return 是否登录成功
	 */
	private boolean login() {
		conn = new Connection(ipAddr);
		try {
			// 连接
			conn.connect();
			// 认证
			return conn.authenticateWithPassword(userName, password);
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * 执行Shell脚本或命�?
	 *
	 * @param cmds 命令行序�?
	 * @return 脚本输出结果
	 */
	public StringBuilder exec(String cmds) throws IOException {
		InputStream in = null;
		StringBuilder result = new StringBuilder();
		try {
			if (this.login()) {
				// 打开�?个会�?
				Session session = conn.openSession();
				session.execCommand(cmds);
				in = session.getStdout();
				result = this.processStdout(in, this.charset);
				session.close();
				conn.close();
			}
		} finally {
			if (null != in) {

				in.close();
			}
		}

		return result;
	}

	/**
	 * 解析流获取字符串信息
	 *
	 * @param in      输入流对�?
	 * @param charset 字符�?
	 * @return 脚本输出结果
	 */
	public StringBuilder processStdout(InputStream in, Charset charset) throws FileNotFoundException {
		byte[] buf = new byte[1024];
		StringBuilder sb = new StringBuilder();
//    OutputStream os = new FileOutputStream("./data.txt");
		try {
			int length;
			while ((length = in.read(buf)) != -1) {
//        os.write(buf, 0, c);
				sb.append(new String(buf, 0, length));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb;
	}


}