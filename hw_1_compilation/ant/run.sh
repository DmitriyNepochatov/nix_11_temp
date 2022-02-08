#!/bin/bash

. ./setantenv.sh

ant compile

ant assembly

ant run