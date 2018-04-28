.model small
.data
        a db 44h
        b db 22h
        c dw ?
.code
start:
        mov al,44h
        mov bl,22h
        mul bl
        mov cl,al
        mov ah,4ch
        int 21h
end start
