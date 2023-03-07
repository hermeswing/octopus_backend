# 아래 내용의 순번은 초기 셋팅의 순서이고, 정렬의 순서는 자주 쓰이는 내용 순으로 정렬했음.

---

# 3. **변경된 내용 적용**

```bash
# Source의 변경이 발생하면
# 변경된 내용을 Staging 영역에 추가
$ git add .

# Git 상태
$ git status
On branch main
Your branch is up to date with 'origin/main'.

Changes to be committed:
  (use "git restore --staged <file>..." to unstage)
        new file:   src/main/java/octopus/backend/basic/HelloWorldController.java

# 변경된 내용을 Commit
$ git commit -m "HelloWorld Controller commit"
[main e66ec7b] HelloWorld Controller commit
 1 file changed, 18 insertions(+)
 create mode 100644 src/main/java/octopus/backend/basic/HelloWorldController.java

# Git Repository로 변경된 소스 Push
$ git push -u origin main
Enumerating objects: 14, done.
Counting objects: 100% (14/14), done.
Delta compression using up to 4 threads
Compressing objects: 100% (7/7), done.
Writing objects: 100% (9/9), 897 bytes | 448.00 KiB/s, done.
Total 9 (delta 1), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (1/1), completed with 1 local object.
To <https://github.com/hermeswing/octopus_backend.git>
   3c0587f..e66ec7b  main -> main
branch 'main' set up to track 'origin/main'.

```

# 5. **브랜치의 파일을 내려 받을 경우**

```bash
# 원격저장소 목록을 update 시킵니다.
$ git remote update
remote: Enumerating objects: 47, done.
remote: Counting objects: 100% (47/47), done.
remote: Compressing objects: 100% (26/26), done.
remote: Total 31 (delta 9), reused 23 (delta 4), pack-reused 0
  origin/add_message
  origin/main

# 원격저장소의 branch 목록 조회
$ git branch -r
  origin/addCodeManage
  origin/add_message
  origin/main

# 원격저장소의 branch를 내려받는습니다.
$ git checkout -t origin/addCodeManage
Switched to a new branch 'addCodeManage'
branch 'addCodeManage' set up to track 'origin/addCodeManage'.

```

# 4. **브랜치 생성 후 push**

```bash
# 브랜치를 생성합니다.
# git branch 브랜치명
$ git branch addCodeManage

# 해당 브랜치로 이동합니다.
$ git checkout 브랜치명
$ git checkout addCodeManage

# 위에 명령어를 한 번에 치고 싶으면 :
# git checkout -b 브랜치명
$ git checkout -b addCodeManage

# 브랜치로 이동했는지 확인
$ git branch

# 변경된 파일을 add
$ git add .

# 커밋 메시지와 함께 커밋
$ git commit -m '커밋메시지'

# 원격저장소의 branch와 로컬저장소의 branch가 같을 경우
$ git push
fatal: The current branch addCodeManage has no upstream branch.
To push the current branch and set the remote as upstream, use

    git push --set-upstream origin addCodeManage

To have this happen automatically for branches without a tracking
upstream, see 'push.autoSetupRemote' in 'git help config'.

# 원격저장소에 branch가 없고, 로컬저장소에 branch를 올릴 경우
# git push --set-upstream A B 를 하게 되면 로컬 A 저장소의 원격저장소를 B 로 지정하여 B 에 push 하라는 의미에용
$ git push --set-upstream origin addCodeManage
Enumerating objects: 172, done.
Counting objects: 100% (172/172), done.
Delta compression using up to 4 threads
Compressing objects: 100% (145/145), done.
Writing objects: 100% (161/161), 86.76 KiB | 2.55 MiB/s, done.
Total 161 (delta 52), reused 0 (delta 0), pack-reused 0
remote: Resolving deltas: 100% (52/52), completed with 4 local objects.
remote:
remote: Create a pull request for 'addCodeManage' on GitHub by visiting:
remote:      <https://github.com/hermeswing/octopus_backend/pull/new/addCodeManage>
remote:
To <https://github.com/hermeswing/octopus_backend.git>
 * [new branch]      addCodeManage -> addCodeManage
branch 'addCodeManage' set up to track 'origin/addCodeManage'.

```

# 2. **프로젝트 Clone**

```bash
# 폴더 이동
$ cd /c/Octopus/workspace ( workspace 까지만 이동해야 합니다. )

# Github Repository Clone
# git clone 원격저장소주
$ git clone <https://github.com/hermeswing/octopus_backend.git>

# Clone 받은 폴더로 이동
$ cd octopus_backend

```

# 1. **프로젝트 생성**

```bash
# Git 프로젝트 초기화
$ git init

# 변경된 파일을 Staging 영역에 등록
$ git add .

# 변경된 파일을 Staging 영역에 Commit
$ git commit - "first commit"

# Branch명을 master 에서 main으로 변경
$ git branch -M main

# Git 프로젝트 폴더를 Github Repository 와 연결
$ git remote add origin <https://github.com/hermeswing/octopus_backend.git>

# Git 프로젝트 폴더의 Source를 Github Repository
$ Push >> git push -u origin main
```