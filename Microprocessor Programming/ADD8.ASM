.model small
.data
        a db 22h
        b db 66h
        c dw ?
.code
start:  mov al,22h
        mov bl,66h
        add al,bl
        mov cl,al
        mov ah,4ch
        int 21h
end

