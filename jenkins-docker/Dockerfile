FROM jenkins/jenkins:lts
USER root

RUN apt-get update && apt-get install -y docker.io curl

RUN curl -LO "https://dl.k8s.io/release/$(curl -L -s https://dl.k8s.io/release/stable.txt)/bin/linux/amd64/kubectl" \
  && install -o root -g root -m 0755 kubectl /usr/local/bin/kubectl \
  && rm kubectl

COPY plugins.txt /usr/share/jenkins/ref/plugins.txt
RUN jenkins-plugin-cli --plugin-file /usr/share/jenkins/ref/plugins.txt

USER jenkins
