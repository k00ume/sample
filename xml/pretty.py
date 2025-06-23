#!/usr/bin/env python3
import re
from xml.dom import minidom

def main():
    with open('sample.xml', encoding='UTF-8') as fi:
        s = re.sub(r'(^[ \t]+|\r?\n)', '', fi.read())
        dom = minidom.parseString(s)

        with open('pretty.xml', 'w', encoding='UTF-8', newline='') as fo:
            fo.write(dom.toprettyxml(' ' * 2))

if __name__ == "__main__":
    main()
