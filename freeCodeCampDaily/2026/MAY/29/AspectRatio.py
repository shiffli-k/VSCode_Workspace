# 29May2026
# Given two strings for different image dimensions, return the aspect ratio of the image with a greater width-to-height ratio.

# The given strings will be in the format "WxH", for example, "1920x1080".
# The aspect ratio is the ratio of width to height, reduced to the lowest whole numbers. For example, "1920x1080" reduces to "16:9".
# Return a string in format "W:H", for example, "16:9".

import math as m

def get_wider_aspect_ratio(firstRes, secondRes):
    
    # Split by w & h
    w1 = int(firstRes.split("x")[0])
    h1 = int(firstRes.split("x")[1])
    
    w2 = int(secondRes.split("x")[0])
    h2 = int(secondRes.split("x")[1])
    
    # Get the largest wxh
    if(w1*h2 > w2*h1):
        (w,h) = (w1, h1)
    else:
        (w,h) = (w2, h2)

    # get GCD for that wxh
    gcdVal = m.gcd(w,h)

    (r1,r2) = (int(w/gcdVal), int(h/gcdVal))

    # return values
    return str(r1) + ":" + str(r2)

print(
get_wider_aspect_ratio("1920x1080", "800x600"),
get_wider_aspect_ratio("1080x1350", "2048x1536"),
get_wider_aspect_ratio("640x480", "2440x1220"),
get_wider_aspect_ratio("360x640", "1080x1920"),
get_wider_aspect_ratio("3440x1440", "2048x858"),
get_wider_aspect_ratio("12345x61234", "12534x51234")
)