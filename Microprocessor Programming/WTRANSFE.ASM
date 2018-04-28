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
        CLD
        REP MOVSB
int 03h
end start
