FROM registry.access.redhat.com/jboss-eap-6/eap64-openshift

EXPOSE 8080

RUN curl https://raw.githubusercontent.com/oybed/example-jms-webapp/master/example-jms-webapp.war -o $JBOSS_HOME/standalone/deployments/ROOT.war

