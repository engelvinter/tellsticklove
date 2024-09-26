# The is automatic generated Code by "makePipRecipes.py"
# (build by Robin Sebastian (https://github.com/robseb) (git@robseb.de) Vers.: 1.2) 

SUMMARY = "Recipe to embedded the Python PiP Package tellcore-py"
HOMEPAGE ="https://pypi.org/project/tellcore-py"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d32239bcb673463ab874e80d47fae504"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-wheel"

PYPI_PACKAGE = "tellcore-py"

ALLOW_EMPTY:${PN} = "1"

SRC_URI[md5sum] = "355e7c662aff1a6bf9253186d8447d0b"
SRC_URI[sha256sum] = "403d8e9d4f8ad95bda4c681f4d897c7633b48d25ee85b5bf39f30a362a49b122"

