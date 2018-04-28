.model small
.data
        a dw 4444h
        b dw 0002h
        c dw ?
.code
start:
        mov ax,4444h
        mov bx,0002h
        mul bx
        mov cx,ax
        mov ah,4ch
        int 21h
end start
