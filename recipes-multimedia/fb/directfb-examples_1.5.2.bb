SUMMARY = "Example DirectFB applications"
DESCRIPTION = "The DirectFB-examples package contains a set of simple DirectFB \
      applications that can be used to test and demonstrate various DirectFB \
      features"
DEPENDS = "directfb"
SECTION = "libs"
LICENSE = "MIT"

SRC_URI = " \
           http://www.directfb.org/downloads/Extras/DirectFB-examples-${PV}.tar.gz \
           file://configure.in-Fix-string-argument-syntax.patch \
          "

LIC_FILES_CHKSUM = "file://COPYING;md5=ecf6fd2b19915afc4da56043926ca18f"

S = "${WORKDIR}/DirectFB-examples-${PV}"

inherit autotools pkgconfig

SRC_URI[md5sum] = "e1c7babb9bb02f9aff8c45f07968458c"
SRC_URI[sha256sum] = "7f8362cb69fabedeaf1d4ef531488726d1170b233ed4e801085fb55f8e3a8478"

