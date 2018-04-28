.model small
.data
        a dw 8888h
        b dw 4444h
        c dw ?
.code
start:
        mov ax,8888h
        mov bx,4444h
        div bx
        mov cx,ax
        mov ah,4ch
        int 21h
end start
