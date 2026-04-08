
## keep track in two repository:

1. https://github.com/apihug/apihug-archetype
2. https://gitee.com/apihug/rad.git


Used by the `REPL` `hope.common.repl.commands.MarketInstallCommands`:

```java
public static final String[] OFFICIAL_ARCHETYPES_GITS =
        new String[] {
                "https://github.com/apihug/apihug-archetype.git", "https://gitee.com/apihug/rad.git"
        };
```

### command

remember to push two git

```shell
git push 
git push --all gh
```

git config:

```shell
[core]
	repositoryformatversion = 0
	filemode = false
	bare = false
	logallrefupdates = true
	symlinks = false
	ignorecase = true
[remote "origin"]
	url = https://gitee.com/apihug/rad.git
	fetch = +refs/heads/*:refs/remotes/origin/*
[branch "main"]
	remote = origin
	merge = refs/heads/master
[remote "gh"]
	url = https://github.com/apihug/apihug-archetype.git
	fetch = +refs/heads/*:refs/remotes/origin/*
```
