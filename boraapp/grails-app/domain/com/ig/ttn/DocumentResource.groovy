package com.ig.ttn

class DocumentResource  extends Resource{
String filePath;
    static constraints = {
        filePath blank: false
    }
}
