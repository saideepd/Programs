.model small
.stack 100
.data
        array db 01h,02h,03h,04h,05h,06h,07h,08h,09h,10h
        max db 10
.code
start:  mov ax,@data
	mov ds,ax
	xor di,di
	mov cl,10
	lea bx,array
	mov al,max
back:   cmp al,[bx+di]
        jc skip
        mov al,[bx+di]
skip:   inc di
        dec cl
        jnz back
	mov max,al
	mov ah,4ch
	int 21h
end start
