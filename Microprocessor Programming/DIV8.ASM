.model small
.data
        a db 88h
        b db 22h
        c dw ?
.code
start:
        mov al,88h
        mov bl,22h
        div bl
        mov cl,al
        mov ah,4ch
        int 21h
end start
