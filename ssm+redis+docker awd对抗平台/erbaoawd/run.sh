#!/bin/sh
cd /var/www/html
service ssh start
a2enmod rewrite
service apache2 start
service mysql start
umask 644
groupadd ctf
useradd ctf -g ctf
echo ctf:erbaoctf | chpasswd
chown -R ctf:ctf /app
sleep 2
mysql -uroot -proot < *.sql
if [ -x "extra.sh" ]; then 
./extra.sh
fi
/bin/bash