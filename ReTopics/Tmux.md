[Tmux Installation Homepage](https://github.com/tmux/tmux/wiki/Installing)
## Installation For macOS

### Step 1: Install Tmux using homebrew

``` zsh
brew install tmux
```

### Step 2: Installing the Tmux package manager. This will allow you to extend the functionality of Tmux by using open sourced maintained packages.

```bash
git clone https://github.com/tmux-plugins/tpm ~/.tmux/plugins/tpm
```

### Step 3: Editing the config file. 

First create an empty config file at ~/.config/tmux/tmux.conf

```bash
touch ~/.config/tmux/tmux.conf
```

If it fails then the directory does not exists so we first create the directory.

```bash
mkdir -p ~/.config/tmux
```

Then run the follow command above.

The next step is to edit the empty conf file, so open the file using the editor of your choice.

#### **Using vim**:
```bash
vim ~/.config/tmux/tmux.conf
```

#### Using vsc:
```bash
code ~/.config/tmux/tmux.conf
```

The paste in the conf file and save
```
set -g @plugin 'tmux-plugins/tpm' 
set -g @plugin 'tmux-plugins/tmux-sensible' 

run '~/.tmux/plugins/tpm/tpm'
```

### Final Step
Run:
```bash
tmux
```

Or reload conf file if tmux already running:
```bash
tmux source ~/.config/tmux/tmux.conf
```


## How to use tmux

Tmux consists of three hierarchal parts
1. The Session is the top most structure containing your workspace i.e all the windows and of its panes. Each workspace can have one active window so show one window at a time.
2. Windows are containers to panes. Think of it as a layout you can see and swap between so like on a mac you can swap between windows and each windows has it's own setup. To elaborate it can contain multiple or a singular and is used to managed layouts and allowing your to have different pages of setup.
3. The Pane is the indivudual components within each window. So in the window you can split it horozonital or vertical creating panes. Each window has one active pane

On the bottom will show each active window and the window with a * next to it is the current active window.

To invoke commands you have to first follow with the prefix key
```
ctrl + b and let go
```


#### Creating a new window
```
<prefix> c
```

#### Changing window 
By window number
```
<prefix> {corresponding window number}
```
Scrolling next
```
<prefix> n
```
Scrolling previous
```
<prefix> p
```

#### Swapping windows around

```
<prefix> : 

And then followed by entering the command

swap-window -s {window} -t {window}

ex: swaps window 3 and 1
swap-window -s 3 -t 1

Swap Current window with top window (window at index 0)
swap-window -t 0


```

### Killing windows:
```
<prefix> & 
```

### Managing Panes

split pane vertically
```
<prefix> + %
```

split pane horizontally
```
<prefix> + "
```

Navigation
```
<prefix> + then using the arrow key for direction
```

Swapping panes around
```
<prefix> + { and }
```

panes have numbers and { moves it back while } moves it forward and swaps indexes with the next following one

View the number assoicated with each pane
```
<prefix> + q
```

To Focus on a pane (zoom and and fullscreen it)
```
<prefix> + z
```
press again to go back to the wide view

To Make a pane its own separate window
```
<prefix> + !
```

To close a pane
```
<prefix> + x
```


### Sessions

##### Creating New Session
Create a new session while not attached to a current tmux session
``` bash
tmux
```

Create with a name ^1f6644
```
tmux new -s my-session
```

Creating New session while inside a tmux session
```
<prefix> + : + new
```

##### Viewing Session
View all sessions outside an attached tmux session
```
tmux ls
```

View inside a session
```
<prefix> + s
```
to exit or select a session press enter on a session

##### Attaching to a Session
to attach to the latest session
```
tmux attach
```

to attach to a specific session 
```
tmux attach -d -t {session name}
```
note when working with a bunch of sessions it's important to name a session when creating a new session [[#^1f6644]]

wouldn't you know i did all this and then there's this site with all the keybinds and more

[CHEAHT SHEET](https://tmuxcheatsheet.com/)
