Vagrant.configure(2) do |config|
  config.vm.box = "ubuntu/focal64"
  config.vm.hostname = "testserver"
  config.vm.network "forwarded_port",
    id: 'ssh', guest: 22, host: 2202, host_ip: "127.0.0.1", auto_correct: false
  config.ssh.forward_agent = true
  # disable updating guest additions
  if Vagrant.has_plugin?("vagrant-vbguest")
    config.vbguest.auto_update = false
  end
  # config.vm.provision "shell", path: "./scripts/install-scala.sh", privileged: false
  config.vm.provider "virtualbox" do |virtualbox|
    virtualbox.name = "scala"
  end
end
