.model small
.data
        a dw 4444h
        b dw 2222h
        c dw ?
.code
        start:
        mov ax,4444h
        mov bx,2222h
        add ax,bx
        mov cx,ax
        mov ah,4ch
        int 21h
end
