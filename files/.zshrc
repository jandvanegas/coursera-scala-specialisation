if [[ -r "${XDG_CACHE_HOME:-$HOME/.cache}/p10k-instant-prompt-${(%):-%n}.zsh" ]]; then
  source "${XDG_CACHE_HOME:-$HOME/.cache}/p10k-instant-prompt-${(%):-%n}.zsh"
fi
export PATH="$HOME/.local/share/coursier/bin/:$PATH"
export ZSH=$HOME/.oh-my-zsh
# export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64
ZSH_THEME="powerlevel10k/powerlevel10k"
plugins=(git zsh-autosuggestions zsh-syntax-highlighting)
source $ZSH/oh-my-zsh.sh

source /usr/share/doc/fzf/examples/key-bindings.zsh
source /usr/share/doc/fzf/examples/completion.zsh

[[ ! -f ~/.p10k.zsh ]] || source ~/.p10k.zsh
