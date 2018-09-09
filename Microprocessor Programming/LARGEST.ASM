.model small
.stack 100
.data
	array db  00h,01h,02h,03h,04h,05h,06h,07h,08h,09h
	max db 0
.code
start: mov ax,@data
	mov ds,ax
	xor di,di
	mov cl,0Ah
	lea bx,array
	mov al,max
back:	cmp al,[bx+di]
	jnc skip
	mov al,[bx+di]
skip:	inc di
	dec cl
	jnz back
	mov max,al
	mov ah,4ch
	int 21h
end start
