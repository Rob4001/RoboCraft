package couk.rob4001.robocraft.gui;

import java.util.LinkedList;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.util.MathHelper;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import couk.rob4001.robocraft.research.ResearchItem;
import couk.rob4001.robocraft.research.ResearchMap;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GUIJournal extends GuiScreen {

	/** The top x coordinate of the research map */
	private static final int guiMapTop = -(ResearchMap.minDisplayColumn * -12) ;

	/** The left y coordinate of the research map */
	private static final int guiMapLeft = -(ResearchMap.minDisplayRow * 12) ;

	/** The bottom x coordinate of the research map */
	private static final int guiMapBottom = ResearchMap.maxDisplayColumn * 12 ;

	/** The right y coordinate of the research map */
	private static final int guiMapRight = ResearchMap.maxDisplayRow * 12;
	
	protected int researchsPaneWidth = 256;//TODO:Change to size of outer boarder picture in pixels
	protected int researchsPaneHeight = 202;//TODO^^

	/** The current mouse x coordinate */
	protected int mouseX = 0;

	/** The current mouse y coordinate */
	protected int mouseY = 0;
	protected double shouldX;
	protected double shouldY;

	/** The x position of the research map */
	protected double guiMapX;

	/** The y position of the research map */
	protected double guiMapY;
	protected double atX;
	protected double atY;

	/** Whether the Mouse Button is down or not */
	private int isMouseButtonDown = 0;
	private LinkedList<ResearchItem> Researchs = new LinkedList<ResearchItem>();

	  public static int lastX = -5;
	  public static int lastY = -6;
	
	public GUIJournal() {
		System.out.println(guiMapTop+":"+guiMapBottom+":"+guiMapRight+":"+guiMapLeft);
		short var2 = 141;
		short var3 = 141;
		this.atX = lastX * 24 - var2 / 2 - 12;
		
	    this.atY = lastY * 24 - var3 / 2;
		this.Researchs.clear();
		for (Object research : ResearchMap.researchList) {
			if (!ResearchMap.isResearch((ResearchItem) research)) {
				this.Researchs.add((ResearchItem) research);
			}
		}
	}

	/**
	 * Adds the buttons (and other controls) to the screen in question.
	 */
	@Override
	public void initGui() {
		this.controlList.clear();
		this.controlList.add(new GuiSmallButton(1, this.width / 2 + 24,
				this.height / 2 + 74, 80, 20, LanguageHelper
						.translateToLocal("gui.done")));
	}

	/**
	 * Fired when a control is clicked. This is the equivalent of
	 * ActionListener.actionPerformed(ActionEvent e).
	 */
	@Override
	protected void actionPerformed(GuiButton par1GuiButton) {
		if (par1GuiButton.id == 1) {
			this.mc.displayGuiScreen((GuiScreen) null);
			this.mc.setIngameFocus();
		}

		super.actionPerformed(par1GuiButton);
	}

	/**
	 * Fired when a key is typed. This is the equivalent of
	 * KeyListener.keyTyped(KeyEvent e).
	 */
	@Override
	protected void keyTyped(char par1, int par2) {
		if (par2 == this.mc.gameSettings.keyBindInventory.keyCode) {
			this.mc.displayGuiScreen((GuiScreen) null);
			this.mc.setIngameFocus();
		} else {
			super.keyTyped(par1, par2);
		}
	}

	/**
	 * Draws the screen and all the components in it.
	 */
	@Override
	public void drawScreen(int mouseX, int mouseY, float ticks) {
		if (Mouse.isButtonDown(0)) {
			System.out.println("q:"+this.atX + " r:" + this.atY + " m:" + this.shouldX + " n:" + this.shouldY );
			int borderWidth = (this.width - this.researchsPaneWidth) / 2;
			int boardrHeight = (this.height - this.researchsPaneHeight) / 2;
			int detectX = borderWidth + 8;
			int detectY = boardrHeight + 17;

			if ((this.isMouseButtonDown == 0 || this.isMouseButtonDown == 1)
					&& mouseX >= detectX && mouseX < detectX + 224 && mouseY >= detectY
					&& mouseY < detectY + 155) {
				if (this.isMouseButtonDown == 0) {
					this.isMouseButtonDown = 1;
				} else {
					this.guiMapX -= mouseX - this.mouseX;
					this.guiMapY -= mouseY - this.mouseY;
					this.atX = this.shouldX = this.guiMapX;
					this.atY = this.shouldY = this.guiMapY;
				}

				this.mouseX = mouseX;
				this.mouseY = mouseY;
			}

			if (this.atX < guiMapTop) {
				this.atX = guiMapTop;
			}

			if (this.atY < guiMapLeft) {
				this.atY = guiMapLeft;
			}

			if (this.atX >= guiMapBottom) {
				this.atX = guiMapBottom - 1;
			}

			if (this.atY >= guiMapRight) {
				this.atY = guiMapRight - 1;
			}
		} else {
			this.isMouseButtonDown = 0;
		}

		this.drawDefaultBackground();
		this.genResearchBackground(mouseX, mouseY, ticks);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		this.drawTitle();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
	}

	/**
	 * Called from the main game loop to update the screen.
	 */
	@Override
	public void updateScreen() {
		this.shouldX = this.guiMapX;
		this.shouldY = this.guiMapY;
		double var1 = this.atX - this.guiMapX;
		double var3 = this.atY - this.guiMapY;

		if (var1 * var1 + var3 * var3 < 4.0D) {
			this.guiMapX += var1;
			this.guiMapY += var3;
		} else {
			this.guiMapX += var1 * 0.85D;
			this.guiMapY += var3 * 0.85D;
		}
	}

	/**
	 * Draws the "researchs" title at the top of the GUI.
	 */
	protected void drawTitle() {
		int var1 = (this.width - this.researchsPaneWidth) / 2;
		int var2 = (this.height - this.researchsPaneHeight) / 2;
		this.fontRenderer.drawString("Scientific Journal", var1 + 15, var2 + 5,
				4210752);
	}

	protected void genResearchBackground(int mouseX, int mouseY, float ticks) {
		int changeX = MathHelper.floor_double(this.shouldX
				+ (this.guiMapX - this.shouldX) * ticks);
		int changeY = MathHelper.floor_double(this.shouldY
				+ (this.guiMapY - this.shouldY) * ticks);

		if (changeX < guiMapTop) {
			changeX = guiMapTop;
		}

		if (changeY < guiMapLeft) {
			changeY = guiMapLeft;
		}

		if (changeX >= guiMapBottom) {
			changeX = guiMapBottom - 1;
		}

		if (changeY >= guiMapRight) {
			changeY = guiMapRight - 1;
		}

		int backgroundTexture = this.mc.renderEngine.getTexture("/gui/journal.png");
		int boarderTexture = this.mc.renderEngine.getTexture("/achievement/bg.png");
		int guiX = (this.width - this.researchsPaneWidth) / 2;
		int guiY = (this.height - this.researchsPaneHeight) / 2;
		int mapOriginX = guiX + 16;
		int mapOriginY = guiY + 17;
		this.zLevel = 0.0F;
		GL11.glDepthFunc(GL11.GL_GEQUAL);
		GL11.glPushMatrix();
		GL11.glTranslatef(0.0F, 0.0F, -200.0F);

		GL11.glEnable(3553);
	    GL11.glDisable(2896);
	    GL11.glEnable(32826);
	    GL11.glEnable(2903);

	    GL11.glPushMatrix();
	    GL11.glScalef(2.0F, 2.0F, 1.0F);
		int xTexOffset = (int) ((changeX - guiMapTop) / Math.abs(guiMapTop - guiMapBottom) * 288.0F);
		int yTexOffset = (int) ((changeY - guiMapLeft)
				/ Math.abs(guiMapLeft - guiMapRight) * 316.0F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(backgroundTexture);
		this.drawTexturedModalRect(mapOriginX/2, mapOriginY/2, (int)this.atX, (int)this.atY, 112, 98);
		GL11.glScalef(0.5F, 0.5F, 1.0F);
	    GL11.glPopMatrix();
		
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);

		List<ResearchItem> ResearchMap = this.Researchs;
		for (int var22 = 0; var22 < ResearchMap.size(); ++var22) {
			ResearchItem var33 = ResearchMap.get(var22);

			//TODO temporarily commented to enable running of StartMod
			/**if (var33.parentResearch != null
					&& ResearchMap.contains(var33.parentResearch)) {
				int var24 = var33.displayColumn * 24 - changeX + 11 + mapOriginX;
				int var25 = var33.displayRow * 24 - changeY + 11 + mapOriginY;
				int var26 = var33.parentResearch.displayColumn * 24 - changeX + 11
						+ mapOriginX;
				int var27 = var33.parentResearch.displayRow * 24 - changeY + 11
						+ mapOriginY;
				int var30 = Math.sin(Minecraft.getSystemTime() % 600L / 600.0D
						* Math.PI * 2.0D) > 0.6D ? 255 : 130;
				int var31 = -16777216;

				this.drawHorizontalLine(var24, var26, var25, var31);
				this.drawVerticalLine(var26, var25, var27, var31);
			}**/
		}

		ResearchItem var32 = null;
		RenderItem var37 = new RenderItem();
		RenderHelper.enableGUIStandardItemLighting();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		int var42;
		int var41;

		for (int var24 = 0; var24 < ResearchMap.size(); ++var24) {
			ResearchItem var35 = ResearchMap.get(var24);
			int var26 = var35.displayColumn * 24 - changeX;
			int var27 = var35.displayRow * 24 - changeY;

			if (var26 >= -24 && var27 >= -24 && var26 <= 224 && var27 <= 155) {
				float var38;

				var38 = 0.3F;
				GL11.glColor4f(var38, var38, var38, 1.0F);

				this.mc.renderEngine.bindTexture(boarderTexture);
				var42 = mapOriginX + var26;
				var41 = mapOriginY + var27;

				if (var35.getSpecial()) {
					this.drawTexturedModalRect(var42 - 2, var41 - 2, 26, 202,
							26, 26);
				} else {
					this.drawTexturedModalRect(var42 - 2, var41 - 2, 0, 202,
							26, 26);
				}

				GL11.glEnable(GL11.GL_LIGHTING);
				GL11.glEnable(GL11.GL_CULL_FACE);
				var37.renderItemAndEffectIntoGUI(this.mc.fontRenderer,
						this.mc.renderEngine, var35.icon, var42 + 3, var41 + 3);
				GL11.glDisable(GL11.GL_LIGHTING);

				GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

				if (mouseX >= mapOriginX && mouseY >= mapOriginY && mouseX < mapOriginX + 224
						&& mouseY < mapOriginY + 155 && mouseX >= var42
						&& mouseX <= var42 + 22 && mouseY >= var41
						&& mouseY <= var41 + 22) {
					var32 = var35;
				}
			}
		}

		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.renderEngine.bindTexture(boarderTexture);
		this.drawTexturedModalRect(guiX, guiY, 0, 0, this.researchsPaneWidth,
				this.researchsPaneHeight);
		GL11.glPopMatrix();
		this.zLevel = 0.0F;
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		super.drawScreen(mouseX, mouseY, ticks);

		//TODO temporarily commented to enable running of StartMod
		/**if (var32 != null) {
			String var34 = LanguageHelper.translateToLocal(var32.getName());
			String var36 = var32.getDescription();
			int var26 = mouseX + 12;
			int var27 = mouseY - 4;

			var42 = Math.max(this.fontRenderer.getStringWidth(var34), 120);
			String var39 = LanguageHelper
					.translateToLocalFormatted("research.requires",
							new Object[] { LanguageHelper
									.translateToLocal(var32.parentResearch
											.getName()) });
			int var30 = this.fontRenderer.splitStringWidth(var39, var42);
			this.drawGradientRect(var26 - 3, var27 - 3, var26 + var42 + 3,
					var27 + var30 + 12 + 3, -1073741824, -1073741824);
			this.fontRenderer.drawSplitString(var39, var26, var27 + 12, var42,
					-9416624);

			this.fontRenderer.drawStringWithShadow(var34, var26, var27,
					var32.getSpecial() ? -128 : -1);
		} **/

		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_LIGHTING);
		RenderHelper.disableStandardItemLighting();
	} 

	/**
	 * Returns true if this GUI should pause the game when it is displayed in
	 * single-player
	 */
	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}

}
