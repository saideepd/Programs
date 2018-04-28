.model small
.code
start:
        mov ax,2000h
        mov ds,ax
        mov ax,3000h
        mov es,ax
        mov si,0000h
        mov di,0000h
        mov cx,0005h
back:   mov al,[si]
        mov es:[di],al
        inc si
        inc di
        loop back
int 03h
end start
