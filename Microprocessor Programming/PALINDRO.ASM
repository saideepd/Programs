.model small
data segment
        Block1 db 25h, 64h, 73h, 99h, 73h, 64h, 25h
        pal db 00h
data ends

extra segment
        Block2 db 07 dup(?)
extra ends

code segment
assume cs:code, ds:data, es:extra
start:  mov ax,data
        mov ds,ax
        mov ax,extra
        mov es,ax
        lea si,Block1
        lea di,Block2+06h
        mov cx,0007h
back:   CLD
        LODSB
        STD
        STOSB
        LOOP back
        lea si,Block1
        lea di,Block2
        mov cx,0007h
        CLD
        REP CMPSB
        JNZ skip
        mov pal,01h
        mov ah,pal
skip:   int 03h
code ends
end start
