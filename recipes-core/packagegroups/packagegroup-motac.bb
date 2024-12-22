
LICENSE = "MIT"

PACKAGE_ARCH = "${MACHINE_ARCH}"
inherit packagegroup

#************************************************************************************************

COMPATIBLE_MACHINE = "^rpi$"

OMXPLAYER  = "${@bb.utils.contains('MACHINE_FEATURES', 'vc4graphics', '', 'omxplayer', d)}"

RDEPENDS:${PN} += "\
"
#    pi-blaster \
#    ${OMXPLAYER} \
#    bcm2835-tests \
#    python3-adafruit-circuitpython-register \
#    python3-adafruit-platformdetect \
#    python3-adafruit-pureio \
#    python3-rtimu \
#    connman \
#    connman-client \
#    wireless-regdb-static \
#    bluez5 \
#    raspi-gpio \
#    rpio \
#    rpi-gpio \
#    userland \
#

RRECOMMENDS:${PN} = "\
    ${@bb.utils.contains("BBFILE_COLLECTIONS", "meta-multimedia", "bigbuckbunny-1080p bigbuckbunny-480p bigbuckbunny-720p", "", d)} \
    ${MACHINE_EXTRA_RRECOMMENDS} \
"
#************************************************************************************************

RDEPENDS:${PN} += "\
  weston-init \
  weston-examples \
  kbd-keymaps \
  vim \
  networkmanager \
  openssh \
  iproute2 \
  netcat-openbsd \
  avahi-autoipd \
  avahi-utils\
  libavahi-glib \
  libavahi-gobject \
  dtc \
  binutils \
  gdbserver \
  gtk4 \
  python3-modules \
  tcpdump \
  libgpiod-tools \
  alsa-utils \
"
#
#   
#  vala \
#
