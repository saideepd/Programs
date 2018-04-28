.model small
.code
start:  mov ax,2000h
        mov ds,ax
        mov ch,03h

back2:  mov si,0100h
        mov cl,03h

back1:  mov ax,[si]
        cmp ah,al
        jc skip
        jz skip
        xchg al,ah
        mov [si],ax

skip:   inc si
        dec cl
        jnz back1
        dec ch
        jnz back2
        mov ah,4ch
        int 21h
end start
