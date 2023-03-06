
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
remote:      https://github.com/hermeswing/octopus_backend/pull/new/addCodeManage
remote:
To https://github.com/hermeswing/octopus_backend.git
 * [new branch]      addCodeManage -> addCodeManage
branch 'addCodeManage' set up to track 'origin/addCodeManage'.



