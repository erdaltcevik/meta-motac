SUMMARY = "MOTAC Development filesystem image"
DESCRIPTION = "Development filesystem image for mota-on-CM4"
LICENSE = "MIT"
export IMAGE_BASENAME = "img-motac"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI = " \
  file://dot_bashrc.in \
"
##S = "${WORKDIR}"

inherit core-image
##inherit image populate_sdk
##inherit image

VIRTUAL-RUNTIME_dev_manager ?= "udev"
VIRTUAL-RUNTIME_keymaps ?= "keymaps"

SYSVINIT_SCRIPTS = "${@bb.utils.contains('MACHINE_FEATURES', 'rtc', '${VIRTUAL-RUNTIME_base-utils-hwclock}', '', d)} \
                    modutils-initscripts \
                   "

IMAGE_INSTALL += " \
  weston-init \
  weston-examples \
  openssh \
  networkmanager \
  gtk4 \
  binutils \
"
#
#
#
#
#  
#  
#  iproute2 \
#  netcat-openbsd \
#  avahi-autoipd \
#  avahi-utils\
#  libavahi-glib \
#  libavahi-gobject \
#  dtc \
#  
#  gdbserver \
#  vim \ 
#  kbd-keymaps \
#
##RRECOMMENDS:${PN} = "\
##  ${MACHINE_EXTRA_RRECOMMENDS} \
##"


##SDK_TOOLCHAIN_LANGS:append = " rust "


##BAD_RECOMMENDATIONS:${PN} += " \
##"
#  udev-hwdb \
#  adwaita-icon-theme-symbolic \
# 
#
#
#
#

##PACKAGECONFIG:append:pn-avahi = " \
## \
##"

##ROOTFS_POSTPROCESS_COMMAND += " modify_default_bashrc "

modify_default_bashrc () {
  install ${WORKDIR}/dot_bashrc.in ${D}/home/root/.bashrc
}


##inherit extrausers

# Password: "erdal"
# printf "%q" $(mkpasswd -m sha256crypt erdal)
##PASSWD = "\$5\$Tklv72xH8CmdNdaI\$pf7A2jR/s1eokny1KP0fsGQNz4LIvy2UukZ/ndi4bn2"
##EXTRA_USERS_PARAMS = " \
##  useradd -p '${PASSWD}' -u 1000 -G input,video,wayland,render  erdal; \
##"


