DESCRIPTION = "Linux kernel for the A4 device"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

DEPENDS = "lzop-native"

# Mark archs/machines that this kernel supports
COMPATIBLE_MACHINE = "(alien5)"

inherit kernel

## DEPRECATED! For a4 device tree
#require recipes-kernel/linux/linux-dtb.inc

inherit kernel machine_kernel_pr

KV = "3.14.29"
PV = "${KV}"
LOCALVERSION ?= ""
MACHINE_KERNEL_PR_append = ".4"



SRCREV = ""

SRC_URI = " \
  file://common.tar.xz \
  file://defconfig \
  file://alien5.dts \
"

S = "${WORKDIR}/common"
B = "${WORKDIR}/build"

do_configure_prepend () {
   cp -f ${WORKDIR}/alien5.dts ${S}/arch/arm64/boot/dts/amlogic/
}

do_compile_prepend () {
  install -d ${B}/drivers/amlogic/amports/
  cp -fr ${S}/drivers/amlogic/amports/amstream.o  ${B}/drivers/amlogic/amports/
  install -d ${B}/drivers/amlogic/dvb_tv/
  cp -fr ${S}/drivers/amlogic/dvb_tv/aml.o  ${B}/drivers/amlogic/dvb_tv/
  cp -fr ${S}/drivers/amlogic/dvb_tv/aml_fe.o  ${B}/drivers/amlogic/dvb_tv/
  install -d ${B}/drivers/amlogic/dvb_tv/smartcard
  cp -fr ${S}/drivers/amlogic/dvb_tv/smartcard/smartcard.o  ${B}/drivers/amlogic/dvb_tv/smartcard/
  install -d ${B}/drivers/amlogic/dvb_tv/dm6k/
  cp -fr ${S}/drivers/amlogic/dvb_tv/dm6k/dm6000_fe.o  ${B}/drivers/amlogic/dvb_tv/dm6k/
  install -d ${B}/drivers/media/dvb-core/
  cp -fr ${S}/drivers/media/dvb-core/dvb-core.o  ${B}/drivers/media/dvb-core/
}

do_compile_append() {
    cp ${B}/arch/arm64/boot/dts/amlogic/alien5.dtb  \
       ${B}/arch/arm64/boot/
}

do_rm-work() {
}
