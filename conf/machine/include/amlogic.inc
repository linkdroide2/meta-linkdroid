MACHINE_ESSENTIAL_EXTRA_RDEPENDS += " ${@bb.utils.contains('MACHINE_FEATURES', 'fb', 'amlsetfb', '', d)}"

PREFERRED_PROVIDER_virtual/libgles1 = "opengl-amlogic"
PREFERRED_PROVIDER_virtual/libgles2 = "opengl-amlogic"
PREFERRED_PROVIDER_virtual/egl = "opengl-amlogic"
PREFERRED_PROVIDER_virtual/kodi-aml = "kodi-aml"
PREFERRED_PROVIDER_kodi-aml = "kodi-aml"
PREFERRED_VERSION_kodi = "17.6"

#PREFERRED_VERSION_ffmpeg = "3.2.4"
#PREFERRED_VERSION_ffmpeg = "3.4.2"
#PREFERRED_PROVIDER_x264 = "ffmpeg"

### PREFERRED_PROVIDER_virtual/kernel = "linux-amlogic"
PREFERRED_PROVIDER_jpeg = "libjpeg-turbo"
PREFERRED_PROVIDER_jpeg-native = "libjpeg-turbo-native"

EXTRA_OECONF_append_pn-enigma2 = " --with-alsa --with-alsacard=hw:0 --with-alsamixer=Master --with-fbdev=/dev/fb0 --with-lcddev=/dev/null --with-amlogic"
DEPENDS_append_pn-enigma2 = " libdvbcsa libamcodec libamadec "
EXTRA_OECONF_append_pn-tuxtxt-enigma2 = " --with-fbdev=/dev/fb0"
#EXTRA_OECONF_append_pn-tuxtxt-enigma2 = " --with-fbdev=/dev/fb2"
CC_append_pn-showiframe = " -DHAVE_AMLOGIC -I${STAGING_INCDIR}/amlogic/amcodec -lamcodec"
DEPENDS_append_pn-showiframe = " libamcodec"

# Add "MACHINEBUILD" override for recipes
MACHINEOVERRIDES =. "${@['', '${MACHINEBUILD}:']['${MACHINEBUILD}' != '']}"

BBMASK += "meta-vuplus/recipes-graphics/"
BBMASK += "meta-fulan/recipes-graphics/"
BBMASK += "meta-vuplus/recipes-webkit/"
BBMASK += "../openembedded-core/meta/recipes-multimedia/x264/"
BBMASK += "meta-pure2/recipes-oe-alliance/recipes-multimedia/ffmpeg/"
