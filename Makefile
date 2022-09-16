up:
	vagrant up
	ssh-keygen -f "/home/javanegas/.ssh/known_hosts" -R "[127.0.0.1]:2222"
	./venv/bin/ansible-playbook ./dot-files/terminal-playbook.yml
	./venv/bin/ansible-playbook ./sandboxes.yml
down:
	vagrant destroy -f
restart:
	make down && make up
