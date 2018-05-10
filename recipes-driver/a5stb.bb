SUMMARY = "Enigma2 procfs drivers for ${MACHINE}"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc

KV = "3.14.29"
SRCDATE = "20180418"

PV = "${KV}+${SRCDATE}"
PR = "r1"

SRC_URI = "file://a5stb.ko"

S = "${WORKDIR}"

#INHIBIT_PACKAGE_STRIP = "1"

inherit module

do_compile() {
}

do_install() {
    install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/a5
    install -m 0755 ${WORKDIR}/a5stb.ko ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/a5/
}

do_package_qa() {
}

