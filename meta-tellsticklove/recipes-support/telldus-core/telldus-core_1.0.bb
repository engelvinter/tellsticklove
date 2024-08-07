# telldus-core_1.0.bb

SUMMARY = "Telldus Core - Software for controlling remote switches"
DESCRIPTION = "Telldus Core is a software to control remote switches, for example with a TellStick."
HOMEPAGE = "https://github.com/engelvinter/telldus"
LICENSE = "CLOSED"

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/engelvinter/telldus.git;branch=scarthgap;protocol=https"
SRC_URI += "file://tellstick.conf"

SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/telldus-core"

inherit cmake pkgconfig

DEPENDS = "libconfuse libftdi"

EXTRA_OECMAKE = ""

do_install:append() {
    install -d ${D}${sysconfdir}
    install -m 0644 ${WORKDIR}/tellstick.conf ${D}${sysconfdir}/tellstick.conf
}
