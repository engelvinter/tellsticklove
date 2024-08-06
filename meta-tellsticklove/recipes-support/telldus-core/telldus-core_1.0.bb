# telldus-core_1.0.bb

SUMMARY = "Telldus Core - Software for controlling remote switches"
DESCRIPTION = "Telldus Core is a software to control remote switches, for example with a TellStick."
HOMEPAGE = "https://github.com/engelvinter/telldus"
LICENSE = "CLOSED"

SRC_URI = "git://github.com/engelvinter/telldus.git;branch=scarthgap;protocol=https"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git/telldus-core"

inherit cmake pkgconfig

DEPENDS = "libconfuse libftdi"

EXTRA_OECMAKE = ""

do_install() {
    install -d ${D}${bindir}
    install -d ${D}${sysconfdir}
    install -d ${D}${libdir}
    install -d ${D}${includedir}

    oe_runmake install DESTDIR=${D}
}

PACKAGES =+ "${PN}-dev ${PN}-dbg"

FILES_${PN} = "${bindir}/* ${sysconfdir}/* ${libdir}/* ${includedir}/*"
FILES_${PN}-dev = "${includedir}/* ${libdir}/*.so ${libdir}/pkgconfig"
FILES_${PN}-dbg = "${libdir}/debug"
