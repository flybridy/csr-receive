# coding=utf-8
__author__ = 'hcc'

import os, sys
import fnmatch
import time
import datetime
import shutil
import zipfile



if __name__ == "__main__":
    curpath=os.path.abspath('.')
    
    for f in os.listdir("."):
    	if os.path.splitext(f)[1] == ".jar":
    		os.remove(os.path.join(curpath, f))
    
    if os.path.exists(curpath+"\\target\\classes\\"):
    	shutil.rmtree(curpath+"\\target\\classes\\")


    os.system("mvn -f "+curpath+"/pom.xml install -Dmaven.test.skip=true")
    os.system("mvn -f "+curpath+"/pom.xml dependency:copy-dependencies -Dmaven.test.skip=true")
    

    deppath=curpath+"\\target\\dependency\\"
    deppathchg=curpath+"\\target\\dependency-change\\"

    if os.path.exists(deppathchg):
        shutil.rmtree(deppathchg)
    os.mkdir(deppathchg)

    zipfilename = curpath + "\\target\\dependency-change" + '.zip'
    if os.path.exists(zipfilename):
        os.remove(zipfilename)

    zipf=zipfile.ZipFile(zipfilename,'w',zipfile.ZIP_DEFLATED)

    time.sleep(2)
    files = os.listdir(deppath)
    for file in files:
        if fnmatch.fnmatch(file,'*.jar'):
            fileName = os.path.join(deppath, file)
            if time.time()-os.stat(fileName).st_mtime<=90:
                print fileName
                os.system('copy /y "'+fileName+'" "'+deppathchg+'"')
                zipf.write(fileName,arcname =os.path.split(fileName)[1] )

    pass

