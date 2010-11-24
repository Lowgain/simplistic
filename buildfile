require 'buildr/scala'

VERSION_NUMBER = "1.0.0"

repositories.remote << "http://www.ibiblio.org/maven2/"

HTTPCLIENT = 'commons-httpclient:commons-httpclient:jar:3.1'
CODEC = 'commons-codec:commons-codec:jar:1.3'
POOL = 'commons-pool:commons-pool:jar:1.4'

SLF4J_VERSION = "1.5.6"
SLF4J = [
  "org.slf4j:slf4j-api:jar:#{SLF4J_VERSION}",
  "org.slf4j:slf4j-log4j12:jar:#{SLF4J_VERSION}",
  "org.slf4j:jcl-over-slf4j:jar:#{SLF4J_VERSION}"
]
LOG4J = "log4j:log4j:jar:1.2.15"

define "simpledb-scala-binding" do
  project.version = VERSION_NUMBER
  project.group = "org.alexboisvert"

  compile.with HTTPCLIENT, CODEC, POOL

  test.using :specs
  test.with LOG4J, SLF4J
end
