# GIt Beginner Guides

## Install Git from official website

1. Download the latest version of Git from [https://git-scm.com/download/win](https://git-scm.com/download/win)

2. Use the dafault/ recommended settings for the installation.

</br>

## Setup the Git

---

You may use either Git Bash or Command Prompt to setup.

- Use &nbsp; `git config --global user.name "<Your name>"` &nbsp; to set your name.
- Use &nbsp; `git config --global user.email "<Your email>"` &nbsp; to set your email.
- Use &nbsp; `git config --list` &nbsp; to check your name and email.

</br>Example:

```text
C:\Users\User> git config --gloval user.name "fyiernzy"
C:\Users\User> git config --global user.email "fyiernzy@gmail.com"
C:\Users\User> git config --list
```

</br>Result:

```text
user.name=fyiernzy
user.email=fyiernzy@gmail.com 
```

</br>

## Cloning the respiratory

---

1. Use &nbsp; `cd <folder/pathway>` &nbsp; to go into the location you want to clone the directory to.
2. Use &nbsp; `git clone <website>` &nbsp; to clone the respiratory.

</br>Example:

```text
C:\Users\User> cd Desktop
C:\Users\User\Desktop> git clone https://github.com/fyiernzy/UM-WIX1002.git
```

</br>Result:

```text
Cloning into 'UM-WIX1002'...
remote: Enumerating objects: 66, done.
Receiving objects:  68% (45/66)sed 0 (delta 0), pack-reused 66
Receiving objects: 100% (66/66), 25.98 KiB | 1.53 MiB/s, done.
Resolving deltas: 100% (4/4), done.
```

</br>

## Basic Syntax

---

- Use &nbsp; `cd <cloned folder>` &nbsp; to go into the clone folder.
- Use &nbsp; `git add .` &nbsp; to add all file
- Use &nbsp; `git commit -m "<message>"` &nbsp; to add a commit message
- Use &nbsp; `git pull` &nbsp; to make your local respiratory up to date
- Use &nbsp; `git push` &nbsp; to update the new changes to the github

</br>Example:

```text
C:\Users\User> cd Desktop
C:\Users\User\Desktop> cd UM-WIX1002
C:\Users\User\Desktop\UM-WIX1002> git add .
C:\Users\User\Desktop\UM-WIX1002> git commit -m "upload new files"
C:\Users\User\Desktop\UM-WIX1002> git pull
C:\Users\User\Desktop\UM-WIX1002> git push
```

</br>Result:

```text
C:\Users\User\Desktop\UM-WIX1002>git add .

C:\Users\User\Desktop\UM-WIX1002>git commit -m "upload new files"
[main 096f510] upload new files
 1 file changed, 36 insertions(+)
 create mode 100644 LCQ1047.java

C:\Users\User\Desktop\UM-WIX1002>git pull
Already up to date.

C:\Users\User\Desktop\UM-WIX1002>git push
Enumerating objects: 4, done.
Counting objects: 100% (4/4), done.
Delta compression using up to 8 threads
Compressing objects: 100% (3/3), done.
Writing objects: 100% (3/3), 647 bytes | 647.00 KiB/s, done.
Total 3 (delta 1), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
To https://github.com/fyiernzy/UM-WIX1002.git
   ba5023e..096f510  main -> main

C:\Users\User\Desktop\UM-WIX1002>git pull
Already up to date.
```

</br>Notes

- Refresh the website if it's not updated yet.
- Always remember to `git pull` before `git push`
- If I deleted a file on Github and pull it, it will shown:

```text
C:\Users\User\Desktop\UM-WIX1002>git pull
remote: Enumerating objects: 3, done.
remote: Counting objects: 100% (3/3), done.
remote: Compressing objects: 100% (2/2), done.
remote: Total 2 (delta 1), reused 0 (delta 0), pack-reused 0
Unpacking objects: 100% (2/2), 599 bytes | 149.00 KiB/s, done.
From https://github.com/fyiernzy/UM-WIX1002
   096f510..3d79105  main       -> origin/main
Updating 096f510..3d79105
Fast-forward
 LCQ1047.java | 36 ------------------------------------
 1 file changed, 36 deletions(-)
 delete mode 100644 LCQ1047.java
```

</br>

## Other useful syntax

---

- `mkdir` - open a new directory (dir = directory)
- `mv` - rename/ move a file
- `ls -a` - list all the file in the dir

</br>

## Naming issues

---

If you are using GitLab to submit your work, you might encounter the following issue:

```bash
$ git pull
remote: Enumerating objects: 462, done.
remote: Counting objects: 100% (462/462), done.
remote: Compressing objects: 100% (461/461), done.
remote: Total 462 (delta 235), reused 0 (delta 0), pack-reused 0
Receiving objects: 100% (462/462), 140.06 KiB | 1.09 MiB/s, done.
Resolving deltas: 100% (235/235), done.
From https://gitlab.com/fop2022/group05
   9d3750d..be19b40  main          -> origin/main
 * [new branch]      L2Q1          -> origin/L2Q1
   7f1754b..49297ca  poisondarterz -> origin/poisondarterz
error: invalid path 'U1234567 /LAB1 /.gitkeep'
Updating 9af9c4c..be19b40
```

This error occurs mainly due to the presence of **whitespace**. For example:

- `LAB1 /` is not a good dir name.
- `LAB1/` is a good dir name.

Similarly:

- `U1234567 /` is not a good dir name
- `U1234567/` is a good dir name
- `L1Q1 .java` is not a good file name
- `L1Q1.java` is a good file name

</br>

> Using bad naming not only trouble yourself, but trouble the others.