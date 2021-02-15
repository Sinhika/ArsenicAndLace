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

# recipes
TARGETDIR=${TOPDIR}/src/main/resources/data/${ID}/recipes
if [ ! -d $TARGETDIR ]; then
    mkdir -p $TARGETDIR
fi
cd $TARGETDIR

# crusher recipes
make_silents_recipes.py --type=crusher --ingredient="${ID}:arsenic_ingot" \
    --result="${ID}:arsenic_dust" arsenic_dust_from_ingot
make_silents_recipes.py --type=crusher --ingredient="${ID}:tenebrium_ingot" \
    --result="${ID}:tenebrium_dust" tenebrium_dust_from_ingot
make_silents_recipes.py --type=crusher --ingredient="${ID}:arsenide_bronze_ingot" \
    --result="${ID}:arsenide_bronze_dust" arsenide_bronze_dust_from_ingot
make_silents_recipes.py --type=crusher --ingredient="${ID}:arsenide_gold_ingot" \
    --result="${ID}:arsenide_gold_dust" arsenide_gold_dust_from_ingot

# alloy smelter
# arsenic
make_silents_recipes.py --type=alloy_smelter --ingredient "${ID}:realgar" \
    "${ID}:orpiment" "minecraft:poisonous_potato" \
    --result "${ID}:large_arsenic_chunk" -- large_arsenic_chunk
make_silents_recipes.py --type=alloy_smelter --ingredient "${ID}:realgar" \
    "${ID}:orpiment" "${ID}:old_lace_chest" \
    --result "${ID}:large_arsenic_chunk" -- large_arsenic_chunk_from_shroud

#arsenide_bronze
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/copper" \
    "#forge:dusts/arsenic" "minecraft:red_dye" \
    --result "${ID}:arsenide_bronze_nugget" -- arsenide_bronze_nugget
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/copper" \
    "#forge:dusts/arsenic" "minecraft:rotten_flesh" \
    --result "${ID}:medium_arsenide_bronze_chunk" -- medium_arsenide_bronze_chunk
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/copper" \
    "#forge:dusts/arsenic" "minecraft:redstone" \
    --result "${ID}:large_arsenide_bronze_chunk" -- large_arsenide_bronze_chunk

#arsenide_gold
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/gold" \
    "#forge:dusts/arsenic" "minecraft:red_dye" \
    --result "${ID}:arsenide_gold_nugget" -- arsenide_gold_nugget
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/gold" \
    "#forge:dusts/arsenic" "minecraft:rotten_flesh" \
    --result "${ID}:medium_arsenide_gold_chunk" -- medium_arsenide_gold_chunk
make_silents_recipes.py --type=alloy_smelter --ingredient "#forge:dusts/gold" \
    "#forge:dusts/arsenic" "minecraft:redstone" \
    --result "${ID}:large_arsenide_gold_chunk" -- large_arsenide_gold_chunk

# tenebrium
make_silents_recipes.py --type=alloy_smelter --ingredient "minecraft:obsidian" \
    "#forge:dusts/arsenide_gold" "minecraft:rotten_flesh" \
    --result "${ID}:tenebrium_nugget" -- tenebrium_nugget
make_silents_recipes.py --type=alloy_smelter --ingredient "minecraft:obsidian" \
    "#forge:dusts/arsenide_gold" "minecraft:gold_nugget" \
    --result "${ID}:medium_tenebrium_chunk" -- medium_tenebrium_chunk
make_silents_recipes.py --type=alloy_smelter --ingredient "minecraft:obsidian" \
    "#forge:dusts/arsenide_gold" "minecraft:quartz" \
    --result "${ID}:large_tenebrium_chunk" -- large_tenebrium_chunk

