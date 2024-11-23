DESCRIPTION = "Creates sudoers in the embedded system"
LICENSE = "CLOSED"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://001_first"

FILES:${PN} += "${sysconfdir}/sudoers.d/001_first"

do_install:append () {
    install -m 0644 ${WORKDIR}/001_first ${D}${sysconfdir}/sudoers.d
}
