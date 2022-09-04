up:
	vagrant up
	ssh-keygen -f "/home/javanegas/.ssh/known_hosts" -R "[127.0.0.1]:2222"
	eval `ssh-agent -s` && ~/customenvs/ansible/bin/ansible-playbook ./sandboxes.yml
down:
	vagrant destroy -f
restart:
	make down && make up
