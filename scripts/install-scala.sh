#!/usr/bin/env bash
set -e
# We are taking the approach to set up the scala environment with coursier
# given that is the official and preferable way.
install_java_8() {
  sudo apt-get update > /dev/null
  sudo apt-get install -y openjdk-8-jdk > /dev/null
}

install_cousier() {
  curl -fL https://github.com/coursier/launchers/raw/master/cs-x86_64-pc-linux.gz | gzip -d > cs
  chmod +x cs
  sudo mv ./cs /opt/cs
  [ -e /usr/local/bin/cs ] && sudo rm /usr/local/bin/cs
  sudo ln -s /opt/cs /usr/local/bin/cs
}

set_up_scala_with_cousier(){
  cs setup --yes --jvm adopt:11
  sudo ln -s $HOME/.local/share/coursier /usr/local/bin/coursier
}

install_java_8
install_cousier
set_up_scala_with_cousier

echo "Saul Goodman"
exit 0
