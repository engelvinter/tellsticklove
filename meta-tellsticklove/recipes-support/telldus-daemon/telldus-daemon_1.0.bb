FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

LICENSE="CLOSED"

inherit systemd

SYSTEMD_AUTO_ENABLE:${PN} = "enable"
SYSTEMD_SERVICE:${PN} = "telldusd.service"

SRC_URI += "file://telldusd.service"
FILES:${PN} += "${systemd_unitdir}/system/telldusd.service"

do_install() {
  install -d ${D}${systemd_unitdir}/system
  install -m 0644 ${WORKDIR}/telldusd.service ${D}${systemd_unitdir}/system/
}
