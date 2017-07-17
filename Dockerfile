FROM openshift/base-centos7
EXPOSE 8080
RUN INSTALL_PKGS="tar unzip bc which lsof java-1.8.0-openjdk java-1.8.0-openjdk-devel" && \
    yum install -y $INSTALL_PKGS && \
    rpm -V $INSTALL_PKGS && \
    yum clean all -y && \
    mkdir -p /opt/s2i/destination

USER 1001

# add application source

ADD ./gradlew /opt/app-root/src/
ADD gradle /opt/app-root/src/gradle
ADD build.gradle /opt/app-root/src/
ADD src /opt/app-root/src/src

# build
RUN sh /opt/app-root/src/gradlew build
# copy to correct location
RUN cp -a  /opt/app-root/src/build/libs/quiz*.jar /opt/app-root/app.jar

ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/opt/app-root/app.jar" ]
