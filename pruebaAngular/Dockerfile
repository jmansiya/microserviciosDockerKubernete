FROM coreos/apache
MAINTAINER Jose Mansilla jmansiya@gmail.com
COPY dist /var/www/
CMD ["-D",  "FOREGROUND"]
ENTRYPOINT ["/usr/sbin/apache2ctl"]