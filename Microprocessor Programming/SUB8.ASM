.model small
.data
        a db 30h
        b db 04h
        c dw ?
.code
        start:
        mov al,30h
        mov bl,04h
        sub al,bl
        mov cl,al
        mov ah,4ch
        int 21h
end
