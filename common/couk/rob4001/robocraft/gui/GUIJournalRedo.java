package couk.rob4001.robocraft.gui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import couk.rob4001.robocraft.research.ResearchItem;
import couk.rob4001.robocraft.research.ResearchMap;
import cpw.mods.fml.relauncher.SideOnly;
import cpw.mods.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSmallButton;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.src.ModLoader;
import net.minecraft.util.MathHelper;

	@SideOnly(Side.CLIENT)
	public class GUIJournalRedo extends GuiScreen
	{
	  private static final int guiMapTop = ResearchMap.minDisplayColumn * 24 - 85;

	  private static final int guiMapLeft = ResearchMap.minDisplayRow * 24 - 112;

	  private static final int guiMapBottom = ResearchMap.maxDisplayColumn * 24 - 112;

	  private static final int guiMapRight = ResearchMap.maxDisplayRow * 24 - 61;

	  protected int paneWidth = 256;
	  protected int paneHeight = 230;

	  protected int mouseX = 0;

	  protected int mouseY = 0;
	  protected double field_74117_m;
	  protected double field_74115_n;
	  protected double guiMapX;
	  protected double guiMapY;
	  protected double field_74124_q;
	  protected double field_74123_r;
	  private int isMouseButtonDown = 0;

	  public static int lastX = -5;
	  public static int lastY = -6;
	  private GuiSmallButton button;
	  private LinkedList<ResearchItem> research = new LinkedList<ResearchItem>();
	  public static HashMap<String,List<Integer>> completedResearch = new HashMap<String,List<Integer>>();
	  private FontRenderer galFontRenderer;
	  private ResearchItem currentHighlight = null;
private String player;

	  public GUIJournalRedo()
	  {
	    short var2 = 141;
	    short var3 = 141;
	    this.field_74124_q = guiMapX = field_74117_m = lastX * 24 - var2 / 2 - 12  ;
	    this.field_74123_r = guiMapY = field_74115_n = lastY * 24 - var3 / 2 ;
	    this.research.clear();
	    for (ResearchItem res: ResearchMap.researchList){

	    this.research.add((ResearchItem)res);
	    }

	    this.galFontRenderer = ModLoader.getMinecraftInstance().fontRenderer;
	    this.player = Minecraft.getMinecraft().session.username;
	  }

	  public GUIJournalRedo(double x, double y)
	  {
	    this.field_74117_m = (this.guiMapX = this.field_74124_q = x);
	    this.field_74115_n = (this.guiMapY = this.field_74123_r = y);
	    this.research.clear();
	    for (ResearchItem res: ResearchMap.researchList){

		    this.research.add((ResearchItem)res);
		    }
	    this.galFontRenderer = ModLoader.getMinecraftInstance().fontRenderer;

	  }

	  public void onGuiClosed()
	  {
	    short var2 = 141;
	    short var3 = 141;
	    lastX = (int)((this.guiMapX + var2 / 2 + 12.0D) / 24.0D);
	    lastY = (int)((this.guiMapY + var3 / 2) / 24.0D);
	    super.onGuiClosed();
	  }

	  public void A_()
	  {
		  this.research.clear();
	  }

	  protected void actionPerformed(GuiButton par1GuiButton)
	  {
		  super.actionPerformed(par1GuiButton);
	  }

	  protected void keyTyped(char par1, int par2)
	    {
	        if (par2 == this.mc.gameSettings.keyBindInventory.keyCode)
	        {
	            this.mc.displayGuiScreen((GuiScreen)null);
	            this.mc.setIngameFocus();
	        }
	        else
	        {
	            super.keyTyped(par1, par2);
	        }
	    }

	  public void drawScreen(int par1, int par2, float par3)
	    {
	    if (Mouse.isButtonDown(0))
	    {
	    	//TODO:Remove System.out.println("q:"+this.field_74124_q + " r:" + this.field_74123_r + " m:" + this.field_74117_m + " n:" + this.field_74115_n );
	      int var4 = (this.width - this.paneWidth) / 2;
	      int var5 = (this.height - this.paneHeight) / 2;
	      int var6 = var4 + 8;
	      int var7 = var5 + 17;

	      if (((this.isMouseButtonDown == 0) || (this.isMouseButtonDown == 1)) && (par1 >= var6) && (par1 < var6 + 224) && (par2 >= var7) && (par2 < var7 + 196))
	      {
	        if (this.isMouseButtonDown == 0)
	        {
	          this.isMouseButtonDown = 1;
	        }
	        else
	        {
	          this.guiMapX -= par1 - this.mouseX;
	          this.guiMapY -= par2 - this.mouseY;
	          this.field_74124_q = (this.field_74117_m = this.guiMapX);
	          this.field_74123_r = (this.field_74115_n = this.guiMapY);
	        }

	        this.mouseX = par1;
	        this.mouseY = par2;
	      }

	      if (this.field_74124_q < guiMapTop)
	      {
	        this.field_74124_q = guiMapTop;
	      }

	      if (this.field_74123_r < guiMapLeft)
	      {
	        this.field_74123_r = guiMapLeft;
	      }

	      if (this.field_74124_q >= guiMapBottom)
	      {
	        this.field_74124_q = (guiMapBottom - 1);
	      }

	      if (this.field_74123_r >= guiMapRight)
	      {
	        this.field_74123_r = (guiMapRight - 1);
	      }
	    }
	    else
	    {
	      this.isMouseButtonDown = 0;
	    }

	    this.drawDefaultBackground();
	    genResearchBackground(par1, par2, par3);
	  }

	  public void updateScreen()
	  {
	    this.field_74117_m = this.guiMapX;
	    this.field_74115_n = this.guiMapY;
	    double var1 = this.field_74124_q - this.guiMapX;
	    double var3 = this.field_74123_r - this.guiMapY;

	    if (var1 * var1 + var3 * var3 < 4.0D)
	    {
	      this.guiMapX += var1;
	      this.guiMapY += var3;
	    }
	    else
	    {
	      this.guiMapX += var1 * 0.85D;
	      this.guiMapY += var3 * 0.85D;
	    }
	  }

	  protected void genResearchBackground(int par1, int par2, float par3)
	  {
	    int var4 = MathHelper.floor_double(this.field_74117_m + (this.guiMapX - this.field_74117_m) * par3);
	    int var5 = MathHelper.floor_double(this.field_74115_n + (this.guiMapY - this.field_74115_n) * par3);

	    if (var4 < guiMapTop)
	    {
	      var4 = guiMapTop;
	    }

	    if (var5 < guiMapLeft)
	    {
	      var5 = guiMapLeft;
	    }

	    if (var4 >= guiMapBottom)
	    {
	      var4 = guiMapBottom - 1;
	    }

	    if (var5 >= guiMapRight)
	    {
	      var5 = guiMapRight - 1;
	    }
	    
	    int var6 = this.mc.renderEngine.getTexture("/mods/robo/textures/items/journal.png");
	    int var7 = this.mc.renderEngine.getTexture("/mods/robo/textures/gui/gui_research.png");
	    int var88 = this.mc.renderEngine.getTexture("/mods/robo/textures/items/journal.png");
	    int var8 = (this.width - this.paneWidth) / 2;
	    int var9 = (this.height - this.paneHeight) / 2;
	    int var10 = var8 + 16;
	    int var11 = var9 + 17;
	    this.zLevel = 0.0F;
	    GL11.glDepthFunc(518);
	    GL11.glPushMatrix();
	    GL11.glTranslatef(0.0F, 0.0F, -200.0F);
	    GL11.glEnable(3553);
	    GL11.glDisable(2896);
	    GL11.glEnable(32826);
	    GL11.glEnable(2903);

	    GL11.glPushMatrix();
	    GL11.glScalef(2.0F, 2.0F, 1.0F);
	    int vx = (int)((var4 - guiMapTop) / Math.abs(guiMapTop - guiMapBottom) * 288.0F);
	    int vy = (int)((var5 - guiMapLeft) / Math.abs(guiMapLeft - guiMapRight) * 316.0F);
	    System.out.println(vx+":"+vy+":"+var4+":"+var5);
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    this.mc.renderEngine.bindTexture("/mods/robo/textures/gui/journal.png");
	    this.drawTexturedModalRect(var10 / 2, var11 / 2, vx / 2, vy / 2, 112, 98);
	    GL11.glScalef(0.5F, 0.5F, 1.0F);
	    GL11.glPopMatrix();

	    GL11.glEnable(2929);
	    GL11.glDepthFunc(515);

	    if (completedResearch.get(this.player) != null) {
	      for (int var22 = 0; var22 < this.research.size(); var22++)
	      {
	        ResearchItem var33 = (ResearchItem)this.research.get(var22);

	        if ((var33.parents != null) && (var33.parents.length > 0))
	        {
	          for (int a = 0; a < var33.parents.length; a++) {
	            if ((var33.parents[a] != null) && (this.research.contains(var33.parents[a]))) {
	              int var24 = var33.displayColumn * 24 - var4 + 11 + var10;
	              int var25 = var33.displayRow * 24 - var5 + 11 + var11;
	              int var26 = var33.parents[a].displayColumn * 24 - var4 + 11 + var10;
	              int var27 = var33.parents[a].displayRow * 24 - var5 + 11 + var11;

	              boolean var28 = ((ArrayList)completedResearch.get(this.player)).contains(var33.id);
	              boolean var29 = ((ArrayList)completedResearch.get(this.player)).contains(var33.parents[a].id);

	              int var30 = Math.sin(Minecraft.getSystemTime() % 600L / 600.0D * 3.141592653589793D * 2.0D) > 0.6D ? 255 : 130;
	              int var31 = -16777216;

	              if (var28)
	              {
	                var31 = -9408400;
	              } else {
	                if (var33.getHidden()) continue;
	                if (var29)
	                {
	                  var31 = 65280 + (var30 << 24);
	                }
	              }

	              this.drawHorizontalLine(var24, var26, var25, var31);
	              this.drawVerticalLine(var26, var25, var27, var31);
	            }
	          }
	        }
	        if ((var33.siblings == null) || (var33.siblings.length <= 0))
	          continue;
	        for (int a = 0; a < var33.siblings.length; a++) {
	          if (((var33.siblings[a] == null) || (!this.research.contains(var33.siblings[a])) || (var33.siblings[a].parents != null)) && ((var33.siblings[a].parents == null) || (Arrays.asList(var33.siblings[a].parents).contains(var33))))
	          {
	            continue;
	          }
	          int var24 = var33.displayColumn * 24 - var4 + 11 + var10;
	          int var25 = var33.displayRow * 24 - var5 + 11 + var11;
	          int var26 = var33.siblings[a].displayColumn * 24 - var4 + 11 + var10;
	          int var27 = var33.siblings[a].displayRow * 24 - var5 + 11 + var11;

	          boolean var28 = ((ArrayList)completedResearch.get(this.player)).contains(var33.id);
	          boolean var29 = ((ArrayList)completedResearch.get(this.player)).contains(var33.siblings[a].id);

	          int var30 = Math.sin(Minecraft.getSystemTime() % 600L / 600.0D * 3.141592653589793D * 2.0D) > 0.6D ? 255 : 130;
	          int var31 = -16777216;

	          if (var28)
	          {
	            var31 = -9408400;
	          } else {
	            if (var33.getHidden()) continue;
	            if (var29)
	            {
	              var31 = 65280 + (var30 << 24);
	            }
	          }

	          this.drawHorizontalLine(var24, var26, var25, var31);
	          this.drawVerticalLine(var26, var25, var27, var31);
	        }
	      }
	    }

	    this.currentHighlight = null;
	    RenderItem var37 = new RenderItem();
	    RenderHelper.enableGUIStandardItemLighting();
	    GL11.glDisable(2896);
	    GL11.glEnable(32826);
	    GL11.glEnable(2903);

	    if (completedResearch.get(this.player) != null) {
	      for (int var24 = 0; var24 < this.research.size(); var24++)
	      {
	        ResearchItem var35 = (ResearchItem)this.research.get(var24);
	        int var26 = var35.displayColumn * 24 - var4;
	        int var27 = var35.displayRow * 24 - var5;

	        if ((var26 < -24) || (var27 < -24) || (var26 > 224) || (var27 > 196))
	        {
	          continue;
	        }
	        if (((ArrayList)completedResearch.get(this.player)).contains(var35.id))
	        {
	          float var38 = 1.0F;
	          GL11.glColor4f(var38, var38, var38, 1.0F);
	        } else {
	          if (var35.getHidden()) continue;
	          if (canUnlockResearch(var35))
	          {
	            float var38 = Math.sin(Minecraft.getSystemTime() % 600L / 600.0D * 3.141592653589793D * 2.0D) < 0.6D ? 0.6F : 0.8F;
	            GL11.glColor4f(var38, var38, var38, 1.0F);
	          }
	          else
	          {
	            float var38 = 0.3F;
	            GL11.glColor4f(var38, var38, var38, 1.0F);
	          }
	        }

	        this.mc.renderEngine.bindTexture("/mods/robo/textures/gui/gui_research.png");
	        int var42 = var10 + var26;
	        int var41 = var11 + var27;

	        if (var35.getSpecial())
	        {
	          this.drawTexturedModalRect(var42 - 2, var41 - 2, 26, 230, 26, 26);
	        }

	        if (!canUnlockResearch(var35))
	        {
	          float var40 = 0.1F;
	          GL11.glColor4f(var40, var40, var40, 1.0F);
	          var37.renderWithColor = false;
	        }

	        if (var35.icon != null) {
	          GL11.glEnable(2896);
	          GL11.glEnable(2884);
	          var37.renderItemAndEffectIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, var35.icon, var42 + 3, var41 + 3);

	          GL11.glDisable(2896);
	        }
	        else {
	          this.mc.renderEngine.bindTexture("/textures/research.png");
	          this.drawTexturedModalRect(var42 + 3, var41 + 3, var35.iconIndex % 16 * 16, var35.iconIndex / 16 * 16, 16, 16);
	        }

	        if (!canUnlockResearch(var35))
	        {
	        	var37.renderWithColor = false;
	        }

	        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

	        if ((par1 < var10) || (par2 < var11) || (par1 >= var10 + 224) || (par2 >= var11 + 196) || (par1 < var42) || (par1 > var42 + 22) || (par2 < var41) || (par2 > var41 + 22))
	          continue;
	        this.currentHighlight = var35;
	      }

	    }

	    GL11.glDisable(2929);
	    GL11.glEnable(3042);
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	    this.mc.renderEngine.bindTexture("/mods/robo/textures/gui/gui_research.png");
	    this.drawTexturedModalRect(var8, var9, 0, 0, this.paneWidth, this.paneHeight);

	    GL11.glPopMatrix();

	    this.zLevel = 0.0F;
	    GL11.glDepthFunc(515);
	    GL11.glDisable(2929);
	    GL11.glEnable(3553);
	    super.drawScreen(par1, par2, par3);


	    if ((completedResearch.get(this.player) != null) && 
	      (this.currentHighlight != null))
	    {
	      String var34 = this.currentHighlight.getName();
	      String var36 = this.currentHighlight.getDescription();
	      int var26 = par1 + 12;
	      int var27 = par2 - 4;
	      FontRenderer fr = this.galFontRenderer;
	      if (!((ArrayList)completedResearch.get(this.player)).contains(this.currentHighlight.id))
	        fr = this.galFontRenderer;
	      if (canUnlockResearch(this.currentHighlight))
	      {
	        int var42 = Math.max(fr.getStringWidth(var34), 120);
	        int var41 = fr.splitStringWidth(var36, var42);

	        if (((ArrayList)completedResearch.get(this.player)).contains(this.currentHighlight.id))
	        {
	          var41 += 12;
	        }

	        this.drawGradientRect(var26 - 3, var27 - 3, var26 + var42 + 3, var27 + var41 + 3 + 12, -1073741824, -1073741824);
	        fr.drawSplitString(var36, var26, var27 + 12, var42, -6250336);

	        if (((ArrayList)completedResearch.get(this.player)).contains(this.currentHighlight.id))
	        {
	          this.galFontRenderer.drawString("Research Completed!", var26, var27 + var41 + 4, -7302913);
	        }
	      }
	      else
	      {
	        int var42 = Math.max(fr.getStringWidth(var36), 120);
	        String var39 = "Missing research";
	        int var30 = fr.splitStringWidth(var39, var42);
	        this.drawGradientRect(var26 - 3, var27 - 3, var26 + var42 + 3, var27 + var30 + 12 + 3, -1073741824, -1073741824);
	        this.galFontRenderer.drawSplitString(var39, var26, var27 + 12, var42, -9416624);
	      }

	      fr.drawString(var34, var26, var27, this.currentHighlight.getSpecial() ? -8355776 : canUnlockResearch(this.currentHighlight) ? -1 : this.currentHighlight.getSpecial() ? -128 : -8355712);
	    }

	    GL11.glEnable(2929);
	    GL11.glEnable(2896);
	    RenderHelper.disableStandardItemLighting();
	  }
//
//	  protected void a(int par1, int par2, int par3)
//	  {
//	    if ((this.currentHighlight != null) && (((ArrayList)completedResearch.get(this.player)).contains(this.currentHighlight.key))) {
//	      Element el = ThaumcraftApi.researchDoc.getElementById(this.currentHighlight.key);
//	      if (el != null)
//	        this.f.a(new GuiResearchRecipe(this.currentHighlight, this.guiMapX, this.guiMapY));
//	    }
//	    super.a(par1, par2, par3);
//	  }
//
//	  private boolean canUnlockResearch(ResearchItem res) {
//	    if ((res.parents != null) && (res.parents.length > 0)) {
//	      for (ResearchItem parent : res.parents) {
//	        if ((parent != null) && (!((ArrayList)completedResearch.get(this.player)).contains(parent.key)))
//	          return false;
//	      }
//	    }
//	    if ((res.parentsHidden != null) && (res.parentsHidden.length > 0)) {
//	      for (ResearchItem parent : res.parentsHidden) {
//	        if ((parent != null) && (!((ArrayList)completedResearch.get(this.player)).contains(parent.key)))
//	          return false;
//	      }
//	    }
//	    return true;
//	  }
//
//	  public boolean f()
//	  {
//	    return false;
//	  }

	private boolean canUnlockResearch(ResearchItem var35) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
