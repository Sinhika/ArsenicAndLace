#!/bin/bash

# scripts are from mod_utils project on my GitHub.

ID='arsenic'
NAME='ArsenicAndLace'
TOPDIR=`pwd`
PROJNAME=`basename $TOPDIR`
if [ $PROJNAME != $NAME ]; then
    echo "Running in wrong directory!"
    exit 1
fi

# blockstates
TARGETDIR=${TOPDIR}/src/main/resources/assets/${ID}/blockstates
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# make simple blockstates
gen_blockstate_jsons.py --type=simple arsenic_block
gen_blockstate_jsons.py --type=simple tenebrium_block
gen_blockstate_jsons.py --type=simple arsenide_gold_block
gen_blockstate_jsons.py --type=simple arsenide_bronze_block
gen_blockstate_jsons.py --type=pressure_plate arsenic_plate

# models
TARGETDIR=${TOPDIR}/src/main/resources/assets/${ID}/models
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

gen_model_jsons.py --type=block arsenic_block
gen_model_jsons.py --type=block tenebrium_block 
gen_model_jsons.py --type=block arsenide_gold_block
gen_model_jsons.py --type=block arsenide_bronze_block

