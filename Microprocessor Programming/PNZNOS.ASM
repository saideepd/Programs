.model small
.code
start:  mov bh,00h
        mov bl,00h
        mov dh,00h
        mov cx,00Ah
        mov ds,ax
        mov si,0100h
back:   mov al,[si]
        ADD al,00h
        JZ zero
        ROL al,1
        JNC POS
        INC bl
        JMP skip
zero:   INC dh
        JMP skip
POS:    INC bh
skip:   INC si
        loop back
        int 03h
end start
