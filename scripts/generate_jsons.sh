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
gen_blockstate_jsons.py --type=simple arsenide_ore_stone
gen_blockstate_jsons.py --type=simple arsenide_ore_deepslate
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

# block models
gen_model_jsons.py --type=block arsenic_block
gen_model_jsons.py --type=block arsenic_ore_stone
gen_model_jsons.py --type=block arsenic_ore_deepslate
gen_model_jsons.py --type=block tenebrium_block 
gen_model_jsons.py --type=block arsenide_gold_block
gen_model_jsons.py --type=block arsenide_bronze_block
gen_model_jsons.py --type=pressure_plate arsenic_plate

# inventory items
gen_model_jsons.py --type=inventory --item_only realgar
gen_model_jsons.py --type=inventory --item_only orpiment
gen_model_jsons.py --type=inventory --item_only arsenide_salt
gen_model_jsons.py --type=inventory --item_only arsenic_ingot
gen_model_jsons.py --type=inventory --item_only arsenic_nugget
gen_model_jsons.py --type=inventory --item_only arsenic_dust
gen_model_jsons.py --type=inventory --item_only medium_arsenic_chunk
gen_model_jsons.py --type=inventory --item_only large_arsenic_chunk
gen_model_jsons.py --type=inventory --item_only arsenide_bronze_ingot
gen_model_jsons.py --type=inventory --item_only arsenide_bronze_nugget
gen_model_jsons.py --type=inventory --item_only arsenide_bronze_dust
gen_model_jsons.py --type=inventory --item_only medium_arsenide_bronze_chunk
gen_model_jsons.py --type=inventory --item_only large_arsenide_bronze_chunk
gen_model_jsons.py --type=inventory --item_only arsenide_gold_ingot
gen_model_jsons.py --type=inventory --item_only arsenide_gold_nugget
gen_model_jsons.py --type=inventory --item_only arsenide_gold_dust
gen_model_jsons.py --type=inventory --item_only medium_arsenide_gold_chunk
gen_model_jsons.py --type=inventory --item_only large_arsenide_gold_chunk
gen_model_jsons.py --type=inventory --item_only tenebrium_ingot
gen_model_jsons.py --type=inventory --item_only tenebrium_nugget
gen_model_jsons.py --type=inventory --item_only tenebrium_dust
gen_model_jsons.py --type=inventory --item_only medium_tenebrium_chunk
gen_model_jsons.py --type=inventory --item_only large_tenebrium_chunk

# tools
gen_model_jsons.py --type=tool --item_only arsenic_sword
gen_model_jsons.py --type=tool --item_only arsenic_shovel
gen_model_jsons.py --type=tool --item_only arsenic_axe
gen_model_jsons.py --type=tool --item_only arsenic_pickaxe
gen_model_jsons.py --type=tool --item_only arsenic_hoe

gen_model_jsons.py --type=tool --item_only tenebrium_sword
gen_model_jsons.py --type=tool --item_only tenebrium_shovel
gen_model_jsons.py --type=tool --item_only tenebrium_axe
gen_model_jsons.py --type=tool --item_only tenebrium_pickaxe
gen_model_jsons.py --type=tool --item_only tenebrium_hoe

gen_model_jsons.py --type=tool --item_only arsenide_bronze_sword
gen_model_jsons.py --type=tool --item_only arsenide_bronze_shovel
gen_model_jsons.py --type=tool --item_only arsenide_bronze_axe
gen_model_jsons.py --type=tool --item_only arsenide_bronze_pickaxe
gen_model_jsons.py --type=tool --item_only arsenide_bronze_hoe

gen_model_jsons.py --type=tool --item_only arsenide_gold_sword
gen_model_jsons.py --type=tool --item_only arsenide_gold_shovel
gen_model_jsons.py --type=tool --item_only arsenide_gold_axe
gen_model_jsons.py --type=tool --item_only arsenide_gold_pickaxe
gen_model_jsons.py --type=tool --item_only arsenide_gold_hoe

# armor sets
gen_model_jsons.py --type=armor --item_only old_lace_chest

gen_model_jsons.py --type=armor --item_only tenebrium_helmet
gen_model_jsons.py --type=armor --item_only tenebrium_chestplate
gen_model_jsons.py --type=armor --item_only tenebrium_leggings
gen_model_jsons.py --type=armor --item_only tenebrium_boots

gen_model_jsons.py --type=armor --item_only arsenide_gold_helmet
gen_model_jsons.py --type=armor --item_only arsenide_gold_chestplate
gen_model_jsons.py --type=armor --item_only arsenide_gold_leggings
gen_model_jsons.py --type=armor --item_only arsenide_gold_boots

gen_model_jsons.py --type=armor --item_only arsenide_bronze_helmet
gen_model_jsons.py --type=armor --item_only arsenide_bronze_chestplate
gen_model_jsons.py --type=armor --item_only arsenide_bronze_leggings
gen_model_jsons.py --type=armor --item_only arsenide_bronze_boots


