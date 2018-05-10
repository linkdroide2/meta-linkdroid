SUMMARY = "Enigma2 A5 extra LKMs for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc


KV = "3.14.29"
SRCDATE = "20180314"

PV = "${KV}+${SRCDATE}"
PR = "r1"

SRC_URI = " file://ampanel.ko file://se2io_se.ko "

S = "${WORKDIR}"

#INHIBIT_PACKAGE_STRIP = "1"

inherit module

do_compile() {
}

do_install() {
    install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/a5/
    install -m 0755 ${WORKDIR}/ampanel.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/a5/
    install -m 0755 ${WORKDIR}/se2io_se.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/a5/
}

do_package_qa() {
}

